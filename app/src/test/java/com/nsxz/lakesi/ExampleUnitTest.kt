package com.nsxz.lakesi

import com.nsxz.lakesi.vm.BaseViewModel
import com.nsxz.lakesi.vm.SharedFlowViewModel
import com.nsxz.lakesi.vm.UserViewModel
import org.junit.Test

import org.junit.Assert.*
import kotlin.reflect.KClass
import kotlin.reflect.KType

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun testAnnotation(){
        System.out.println("hahahhahahhah")
        val kc1=AnnoChild::class.supertypes[0].arguments.first().type?.classifier
        if (kc1 is KClass<*>) {
            System.out.println("bbbb")
        }



        System.out.println(kc1)

    }




}

open class Anno<VM:BaseViewModel>{

}

class AnnoChild:Anno<SharedFlowViewModel>(){

}
