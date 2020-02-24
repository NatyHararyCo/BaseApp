package com.nutworks.baseapp.api.response

data class PersonResponse(
    val count: Int? = null,
    val next: String? = null,
    val previous: Any? = null,
    val results: ArrayList<Result?>? = null
)