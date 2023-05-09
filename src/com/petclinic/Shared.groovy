package com.petclinic

class Shared implements Serializable {
    def steps

    Shared(steps) {
        this.steps = steps
    }

    def someCommmonMethod(){
        steps.println("Hello World!")
    }
}