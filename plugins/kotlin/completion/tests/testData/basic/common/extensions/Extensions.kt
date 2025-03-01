package a.b

class Some {
    inner class Inner {
        fun foo() {
            fun String.localExtension() = 1

            "".<caret>
        }

        fun String.memberExtFun() { }
    }

    val String.memberExtProp: Int get() = 1
}

fun String.extFun() { }
val String.extProp: Int get() = 1

// EXIST: { lookupString: "extFun", itemText: "extFun", tailText: "() for String in a.b", typeText: "Unit", icon: "nodes/function.svg"}
// EXIST: { lookupString: "extProp", itemText: "extProp", tailText: " for String in a.b", typeText: "Int", icon: "org/jetbrains/kotlin/idea/icons/field_value.svg"}
// EXIST: { lookupString: "memberExtFun", itemText: "memberExtFun", tailText: "() for String in Some.Inner", typeText: "Unit", icon: "nodes/function.svg"}
// EXIST: { lookupString: "memberExtProp", itemText: "memberExtProp", tailText: " for String in Some", typeText: "Int", icon: "org/jetbrains/kotlin/idea/icons/field_value.svg"}
// EXIST: { lookupString: "localExtension", itemText: "localExtension", tailText: "() for String", typeText: "Int", icon: "nodes/function.svg"}
