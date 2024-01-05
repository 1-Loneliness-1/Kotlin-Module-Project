import Menu.Companion.getUserInput

class NoteActivity {
    companion object {
        fun startNoteActivity(nameOfSelectedArchive: String, nameOfSelectedNote: String) {
            while(true) {
                val firstLineInOutput = "Действия с заметкой '$nameOfSelectedNote' :"
                val noteMenuElements: ArrayList<String> = arrayListOf(
                    "Показать содержимое заметки",
                    "Назад к списку действий с заметками в архиве '$nameOfSelectedArchive'"
                )

                when(getUserInput(firstLineInOutput, noteMenuElements)) {
                    "0" -> println("Содержимое заметки '$nameOfSelectedNote' :\n${currentArchives[nameOfSelectedArchive]?.get(nameOfSelectedNote)}\n")
                    "1" -> {
                        println("Возврат к списку действий с заметками...\n")
                        break
                    }
                }
            }

        }
    }
}