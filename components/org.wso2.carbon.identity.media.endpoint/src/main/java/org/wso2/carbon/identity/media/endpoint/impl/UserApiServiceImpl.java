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
import org.springframework.beans.factory.annotation.Autowired;
import org.wso2.carbon.identity.media.core.model.MediaInformation;
import org.wso2.carbon.identity.media.endpoint.PrivilegedUserMetadata;
import org.wso2.carbon.identity.media.endpoint.UserApiService;
import org.wso2.carbon.identity.media.endpoint.service.MediaService;

import java.io.InputStream;
import java.util.List;
import javax.ws.rs.core.Response;

import static org.wso2.carbon.identity.media.endpoint.common.MediaServiceConstants.CONTENT_PATH_COMPONENT;
import static org.wso2.carbon.identity.media.endpoint.common.MediaServiceConstants.PUBLIC_PATH_COMPONENT;
import static org.wso2.carbon.identity.media.endpoint.common.Util.getResourceLocation;

/**
 * Provides service implementation for media service privileged user specific operation.
 */
public class UserApiServiceImpl implements UserApiService {

    @Autowired
    private MediaService mediaService;

    @Override
    public Response privilegedUserListMediaInformation(String type, String id) {

        MediaInformation mediaInformation = mediaService.getMediaInformation(type, id);
        return Response.status(Response.Status.OK).entity(mediaInformation).build();
    }

    @Override
    public Response privilegedUserUploadMedia(String type, List<InputStream> filesInputStream,
                                              List<Attachment> filesDetail, PrivilegedUserMetadata metadata) {

        // Only single file upload will be supported in the first phase of the implementation.
        if (filesInputStream.size() > 1) {
            return Response.status(Response.Status.NOT_IMPLEMENTED).build();
        } else {
            mediaService.validateFileUploadMediaTypes(type, filesDetail.get(0).getContentType());
            mediaService.validateFileSize(filesInputStream.get(0));

            String uuid = mediaService.uploadPrivilegedUserMedia(filesInputStream, filesDetail, metadata);

            String mediaAccessLevel;
            if (metadata != null && metadata.getSecurity() != null && metadata.getSecurity().getAllowedAll()) {
                mediaAccessLevel = PUBLIC_PATH_COMPONENT;
            } else {
                mediaAccessLevel = CONTENT_PATH_COMPONENT;
            }

            return Response.created(getResourceLocation(uuid, type, mediaAccessLevel)).build();
        }
    }

    @Override
    public Response privilegedUserDeleteMedia(String type, String id) {

        mediaService.deleteMedia(type, id);
        return Response.noContent().build();
    }
}
