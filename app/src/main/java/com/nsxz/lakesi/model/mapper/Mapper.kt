package com.nsxz.lakesi.model.mapper

interface Mapper<I,O> {
    fun map(input:I):O
}