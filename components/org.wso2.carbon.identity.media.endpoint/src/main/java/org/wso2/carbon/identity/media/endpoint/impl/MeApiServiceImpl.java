/*
 * Copyright (c) 2020, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.wso2.carbon.identity.media.endpoint.impl;

import org.apache.cxf.jaxrs.ext.multipart.Attachment;
import org.wso2.carbon.identity.media.endpoint.MeApiService;
import org.wso2.carbon.identity.media.endpoint.Metadata;

import java.io.InputStream;
import java.util.List;
import javax.ws.rs.core.Response;

/**
 * Provides service implementation for media service end-user specific operation..
 */
public class MeApiServiceImpl implements MeApiService {

    @Override
    public Response deleteMedia(String type, String id) {

        return Response.status(Response.Status.NOT_IMPLEMENTED).build();
    }

    @Override
    public Response listMediaInformation(String type, String id) {

        return Response.status(Response.Status.NOT_IMPLEMENTED).build();
    }

    @Override
    public Response uploadMedia(String type, List<InputStream> filesInputStream, List<Attachment> filesDetail,
                                Metadata metadata) {

        return Response.status(Response.Status.NOT_IMPLEMENTED).build();
    }
}
