package net.jspiner.ask.ui.base

interface Diffable {

    fun isSameItem(other: Diffable): Boolean
}