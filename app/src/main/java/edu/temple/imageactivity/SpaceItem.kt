package edu.temple.imageactivity

/*
    This was another part that required some research. I discovered data classes and since
    each photo required an image and an accompanying description, I combined the two fields
    into one.
 */

data class SpaceItem(val image: Int, val name: String) { }