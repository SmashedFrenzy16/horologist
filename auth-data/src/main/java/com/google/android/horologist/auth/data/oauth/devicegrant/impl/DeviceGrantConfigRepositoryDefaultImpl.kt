/*
 * Copyright 2022 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.android.horologist.auth.data.oauth.devicegrant.impl

import com.google.android.horologist.auth.data.ExperimentalHorologistAuthDataApi
import com.google.android.horologist.auth.data.oauth.devicegrant.DeviceGrantConfigRepository

@ExperimentalHorologistAuthDataApi
public class DeviceGrantConfigRepositoryDefaultImpl(
    private val clientId: String,
    private val clientSecret: String
) :
    DeviceGrantConfigRepository<DeviceGrantDefaultConfig> {

    override suspend fun fetch(): DeviceGrantDefaultConfig = DeviceGrantDefaultConfig(
        clientId = clientId,
        clientSecret = clientSecret
    )
}
