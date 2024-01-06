import Menu.Companion.getUserInput
import NoteActivity.Companion.startNoteActivity

class OpenArchiveActivity {
    companion object {
        fun startOpenArchiveActivity(keyOfSelectedArchive: String) {
            while(true) {
                val namesOfNotes: List<String>? = currentArchives[keyOfSelectedArchive]?.keys?.toList()
                val elementsOfMenu: MutableList<String> = mutableListOf("Создать заметку", "Назад к списку архивов")
                namesOfNotes?.forEach { elementsOfMenu.add("Открыть заметку \'${it}\'") }

                when(val command = getUserInput("Действия с заметками в архиве \'$keyOfSelectedArchive\':", elementsOfMenu)) {
                    "0" -> createNewNote(keyOfSelectedArchive)
                    "1" -> {
                        println("Возврат к списку архивов...\n")
                        break
                    }
                    else -> {
                        val nameOfSelectedNote = namesOfNotes?.get(command.toInt() - 2)
                        startNoteActivity(keyOfSelectedArchive, nameOfSelectedNote!!)
                    }
                }
            }
        }

        private fun createNewNote(nameOfSelectedArchive: String) {
            val nameAndContentOfNote: ArrayList<String> = CreateNoteActivity().createObject()
            currentArchives[nameOfSelectedArchive]?.put(nameAndContentOfNote[0], nameAndContentOfNote[1])
        }
    }
}