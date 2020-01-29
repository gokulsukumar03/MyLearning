package com.android.mylearning.builderpattern

class BuilderPattern {

    private var id: String
    private var vehicleNo: String
    private var name: String
    private var tripType: String
    var mandatory : Boolean?=false

    constructor(builder: Builder) {
        this.id = builder.id
        this.vehicleNo = builder.vehicleNo
        this.name = builder.name
        this.tripType = builder.tripType
    }

    fun getUserId() : String?{
        return id!!
    }

    public companion object {
        class Builder {
            var id= ""
            var vehicleNo=""
            var name=""
            var tripType=""

            fun userId(id: String): Builder {
                this.id = id
                return this
            }

            fun vehicle(vehicleNo: String): Builder {
                this.vehicleNo = vehicleNo
                return this
            }

            fun userName(name: String): Builder {
                this.name = name
                return this
            }

            fun type(tripeType: String): Builder {
                this.tripType = tripType
                return this
            }

            fun build(): BuilderPattern {
                return BuilderPattern(this)
            }
        }
    }
}