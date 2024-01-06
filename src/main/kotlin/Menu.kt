import java.lang.NumberFormatException


class Menu {

    companion object {
        fun getUserInput(firstLine: String, menuElements: List<String>): String {
            var command: String

            while(true) {
                var i = 0
                println(firstLine)
                menuElements.forEach {
                    println("$i. $it")
                    i++
                }
                print("\nВведите номер команды: ")

                command = readln()

                if (command.isEmpty()) {
                    println("Вы ничего не ввели. Пожалуйста, введите цифру от 0 до ${menuElements.size - 1}.\n")
                    continue
                } else if (command[0].isLetter() && command.length == 1) {
                    println("Введена буква. Пожалуйста, введите цифру от 0 до ${menuElements.size - 1}.\n")
                    continue
                } else {
                    try {
                        if (command.toInt() !in menuElements.indices) {
                            println("Введена цифра, не соответствующая элементам на экране. Пожалуйста, введите цифру от 0 до ${menuElements.size - 1}.\n")
                            continue
                        }
                    } catch (e: NumberFormatException) {
                        println("Введена строка. Пожалуйста, введите цифру от 0 до ${menuElements.size - 1}.\n")
                        continue
                    }
                }

                break
            }

            return command
        }

        fun <T: Creatable> getInfoForObject(obj: T): ArrayList<String>  {
            val nameAndContent: ArrayList<String> = arrayListOf()
            println(obj.welcomeString)
            var i = 0
            while(i != obj.elementsOfCreateInterface.size - 1) {
                println(obj.elementsOfCreateInterface[i])
                val text = readln()
                if (text.isNotBlank()) {
                    nameAndContent.add(text)
                    i += 2
                } else {
                    println(obj.elementsOfCreateInterface[i+1])
                }
            }
            println(obj.elementsOfCreateInterface[i])

            return nameAndContent
        }

    }

}

