package ru.ernestoguevara.nameforchild.data.db

import android.content.Context
import android.os.Environment
import ru.ernestoguevara.nameforchild.data.DataConfig
import java.io.File
import java.io.FileOutputStream
import java.io.InputStream
import java.io.OutputStream

class NameForChildCreator {

    fun copyDataBaseIfNotExist(context: Context) {

        createDbDirIfNotExists(context)

        val dbFile: File = context.getDatabasePath(DataConfig.DB_NAME)
        if(dbFile.exists()) return
        val mInput: InputStream = context.getAssets().open(DataConfig.DB_NAME)
        val outfileName: String =
            context.getDatabasePath(DataConfig.DB_NAME).getPath()
        val mOutput: OutputStream = FileOutputStream(outfileName)
        val buffer = ByteArray(1024)
        var mLength: Int
        while (mInput.read(buffer).also { mLength = it } > 0) {
            mOutput.write(buffer, 0, mLength)
        }
        mOutput.flush()
        mInput.close()
        mOutput.close()
    }

    private fun createDbDirIfNotExists(context: Context) {
        val dbDir = File(context.getDatabasePath(DataConfig.DB_NAME).parent)
        if (!dbDir.exists()) {
            dbDir.mkdirs();
        }
    }

}