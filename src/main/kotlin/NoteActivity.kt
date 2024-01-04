class NoteActivity {
    companion object {
        fun startNoteActivity(nameOfSelectedArchive: String, nameOfSelectedNote: String) {
            println("Содержимое заметки \'$nameOfSelectedNote\' :")
            println(currentArchives[nameOfSelectedArchive]?.get(nameOfSelectedNote))
        }
    }
}