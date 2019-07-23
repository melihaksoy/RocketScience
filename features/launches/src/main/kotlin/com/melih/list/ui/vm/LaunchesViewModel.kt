package com.melih.list.ui.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import com.melih.core.base.viewmodel.BaseViewModel
import com.melih.core.extensions.containsIgnoreCase
import com.melih.repository.entities.LaunchEntity
import com.melih.repository.interactors.GetLaunches
import com.melih.repository.interactors.base.handle
import kotlinx.coroutines.flow.collect
import javax.inject.Inject

class LaunchesViewModel @Inject constructor(
    private val getLaunches: GetLaunches,
    private val getLaunchesParams: GetLaunches.Params
) : BaseViewModel<List<LaunchEntity>>() {

    // region Properties

    private val _filteredItems = MediatorLiveData<List<LaunchEntity>>()

    val filteredItems: LiveData<List<LaunchEntity>>
        get() = _filteredItems
    // endregion

    init {
        _filteredItems.addSource(successData, _filteredItems::setValue)
    }

    // region Functions

    /**
     * Triggering interactor in view model scope
     */
    override suspend fun loadData() {
        getLaunches(getLaunchesParams).collect {
            it.handle(::handleState, ::handleFailure, ::handleSuccess)
        }
    }

    fun filterItemListBy(query: String?) {
        _filteredItems.value = if (!query.isNullOrBlank()) {
            successData.value
                ?.filter {
                    it.rocket.name.containsIgnoreCase(query) || it.missions.any { it.description.containsIgnoreCase(query) }
                }
        } else {
            successData.value
        }
    }
    // endregion
}