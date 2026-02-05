package com.example.prac_four.types

data class BookSection(
    val id: String,
    val title: String,
    val preview: String,
    val text: String,
    val author: String,
    val links: List<String>
)