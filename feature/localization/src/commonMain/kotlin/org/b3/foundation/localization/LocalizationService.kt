package org.b3.foundation.localization

import org.b3.foundation.application.ApplicationLifecycleParticipant

class LocalizationService(
    val language: LocalizationState,
) : ApplicationLifecycleParticipant
