/*
 * SPDX-FileCopyrightText: 2020, microG Project Team
 * SPDX-License-Identifier: Apache-2.0
 */

@file:Suppress("UnusedImport")

package org.microg.gms.ui

import android.content.ComponentName
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import androidx.preference.Preference
import androidx.preference.PreferenceCategory
import androidx.preference.SwitchPreferenceCompat
import com.mgoogle.android.gms.R
import org.microg.gms.checkin.CheckinPrefs
import org.microg.gms.gcm.GcmDatabase
import org.microg.gms.gcm.GcmPrefs
import org.microg.gms.settings.SettingsContract
import org.microg.gms.ui.settings.SettingsProvider
import org.microg.gms.ui.settings.getAllSettingsProviders
import org.microg.tools.ui.ResourceSettingsFragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController

class SettingsFragment : ResourceSettingsFragment() {
    private val createdPreferences = mutableListOf<Preference>()

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        super.onCreatePreferences(savedInstanceState, rootKey)

        findPreference<Preference>(PREF_CHECKIN)?.setOnPreferenceClickListener {
            findNavController().navigate(requireContext(), R.id.openCheckinSettings)
            true
        }
        findPreference<Preference>(PREF_GCM)?.setOnPreferenceClickListener {
            findNavController().navigate(requireContext(), R.id.openGcmSettings)
            true
        }
        findPreference<Preference>(PREF_ABOUT)?.setOnPreferenceClickListener {
            findNavController().navigate(requireContext(), R.id.openAbout)
            true
        }
        findPreference<Preference>(PREF_ABOUT)?.summary = getString(R.string.about_version_str, AboutFragment.getSelfVersion(context))

        findPreference<SwitchPreferenceCompat>(SettingsContract.CheckIn.HIDE_LAUNCHER_ICON)?.apply {
            setOnPreferenceChangeListener { _, newValue ->
                requireActivity().hideIcon(newValue as Boolean)
                true
            }

        }

        for (entry in getAllSettingsProviders(requireContext()).flatMap { it.getEntriesStatic(requireContext()) }) {
            entry.createPreference()
        }
    }

    private fun SettingsProvider.Companion.Entry.createPreference(): Preference? {
        val preference = Preference(requireContext()).fillFromEntry(this)
        try {
            if (findPreference<PreferenceCategory>(when (group) {
                    SettingsProvider.Companion.Group.HEADER -> "prefcat_header"
                    SettingsProvider.Companion.Group.GOOGLE -> "prefcat_google_services"
                    SettingsProvider.Companion.Group.OTHER -> "prefcat_other_services"
                    SettingsProvider.Companion.Group.FOOTER -> "prefcat_footer"
                })?.addPreference(preference) == true) {
                createdPreferences.add(preference)
                return preference
            } else {
                Log.w(TAG, "Preference not added $key")
            }
        } catch (e: Exception) {
            Log.w(TAG, "Failed adding preference $key", e)
        }
        return null
    }

    private fun Preference.fillFromEntry(entry: SettingsProvider.Companion.Entry): Preference {
        key = entry.key
        title = entry.title
        summary = entry.summary
        icon = entry.icon
        isPersistent = false
        isVisible = true
        setOnPreferenceClickListener {
            findNavController().navigate(requireContext(), entry.navigationId)
            true
        }
        return this
    }

    override fun onResume() {
        super.onResume()
        val context = requireContext()

        if (GcmPrefs.get(requireContext()).isEnabled) {
            val database = GcmDatabase(context)
            val regCount = database.registrationList.size
            database.close()
            findPreference<Preference>(PREF_GCM)?.summary = context.resources.getString(R.string.service_status_enabled_short) + " - " + resources.getQuantityString(R.plurals.gcm_registered_apps_counter, regCount, regCount)
        } else {
            findPreference<Preference>(PREF_GCM)?.setSummary(R.string.service_status_disabled_short)
        }

        findPreference<Preference>(PREF_CHECKIN)?.setSummary(if (CheckinPrefs.isEnabled(context)) R.string.service_status_enabled_short else R.string.service_status_disabled_short)

        lifecycleScope.launchWhenResumed {
            val entries = getAllSettingsProviders(requireContext()).flatMap { it.getEntriesDynamic(requireContext()) }
            for (preference in createdPreferences) {
                if (!entries.any { it.key == preference.key }) preference.isVisible = false
            }
            for (entry in entries) {
                val preference = createdPreferences.find { it.key == entry.key }
                if (preference != null) preference.fillFromEntry(entry)
                else entry.createPreference()
            }
        }
    }

    companion object {
        const val PREF_ABOUT = "pref_about"
        const val PREF_GCM = "pref_gcm"
        const val PREF_CHECKIN = "pref_checkin"
    }

    init {
        preferencesResource = R.xml.preferences_start
    }
}
