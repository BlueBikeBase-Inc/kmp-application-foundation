package org.b3.foundation.ui.view

enum class ViewHierarchy(val order: Int) {
    THEME(0),
    LOCALIZATION(1),
    USER_VIEW(999),
}
