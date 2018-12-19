/*
 * Copyright 2018 New Vector Ltd
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.matrix.androidsdk.util

import android.content.Context
import com.google.gson.Gson
import com.google.gson.JsonElement
import org.matrix.androidsdk.MXPatterns
import org.matrix.androidsdk.crypto.interfaces.CryptoUtil
import org.matrix.androidsdk.crypto.model.crypto.OlmPayloadContent
import java.io.*
import java.util.zip.GZIPOutputStream

/**
 * Give access to some useful methods to module Crypto
 */
object CryptoUtilImpl : CryptoUtil {
    override fun deleteDirectory(file: File) {
        ContentUtils.deleteDirectory(file)
    }

    override fun getGson(withNullSerialization: Boolean): Gson {
        return JsonUtils.getGson(withNullSerialization)
    }

    override fun getBasicGson(): Gson {
        return JsonUtils.getBasicGson()
    }

    override fun canonicalize(jsonElement: JsonElement): JsonElement {
        return JsonUtils.canonicalize(jsonElement)
    }

    override fun convertToUTF8(s: String): String {
        return JsonUtils.convertToUTF8(s)
    }

    override fun getCanonicalizedJsonString(o: Any): String {
        return JsonUtils.getCanonicalizedJsonString(o)
    }

    override fun createCipherOutputStream(fos: FileOutputStream, context: Context): OutputStream? {
        return CompatUtil.createCipherOutputStream(fos, context)
    }

    override fun createGzipOutputStream(cos: OutputStream): GZIPOutputStream? {
        return CompatUtil.createGzipOutputStream(cos)
    }

    override fun createCipherInputStream(fis: FileInputStream, context: Context): InputStream? {
        return CompatUtil.createCipherInputStream(fis, context)
    }

    override fun convertFromUTF8(string: String): String {
        return JsonUtils.convertFromUTF8(string)
    }

    override fun toOlmPayloadContent(payload: JsonElement): OlmPayloadContent {
        return JsonUtils.toOlmPayloadContent(payload)
    }

    override fun <T> toClass(jsonObject: String?, klass: Class<T>): T? {
        return JsonUtils.toClass(jsonObject, klass)
    }

    override fun isUserId(id: String): Boolean {
        return MXPatterns.isUserId(id)
    }
}