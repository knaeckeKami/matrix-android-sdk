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

package org.matrix.androidsdk.crypto.cryptostore.db.model

import io.realm.RealmObject
import org.matrix.androidsdk.crypto.IncomingRoomKeyRequest
import org.matrix.androidsdk.crypto.cryptostore.db.deserializeFromRealm
import org.matrix.androidsdk.crypto.cryptostore.db.serializeForRealm
import org.matrix.androidsdk.crypto.interfaces.CryptoUtil
import org.matrix.androidsdk.crypto.model.crypto.RoomKeyRequestBody

internal open class IncomingRoomKeyRequestEntity(
        var requestId: String? = null,
        var userId: String? = null,
        var deviceId: String? = null,
        // Serialized
        var requestBodyString: String? = null
) : RealmObject() {

    fun toIncomingRoomKeyRequest(): IncomingRoomKeyRequest {
        return IncomingRoomKeyRequest().apply {
            mRequestId = requestId
            mUserId = userId
            mDeviceId = deviceId
            mRequestBody = getRequestBody()
        }
    }

    fun getRequestBody(): RoomKeyRequestBody? {
        return deserializeFromRealm(requestBodyString)
    }

    fun putRequestBody(requestBody: RoomKeyRequestBody?, cryptoUtil: CryptoUtil) {
        requestBodyString = serializeForRealm(requestBody, cryptoUtil)
    }
}