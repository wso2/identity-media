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

package org.wso2.carbon.identity.media.endpoint;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;

import java.util.Objects;
import javax.validation.Valid;

public class PrivilegedUserSecurityAllOf  {
  
    private List<String> allowedUsers = null;


    /**
    * The set of users entitled to access the file.
    **/
    public PrivilegedUserSecurityAllOf allowedUsers(List<String> allowedUsers) {

        this.allowedUsers = allowedUsers;
        return this;
    }
    
    @ApiModelProperty(example = "[\"user1\",\"user2\"]", value = "The set of users entitled to access the file.")
    @JsonProperty("allowedUsers")
    @Valid
    public List<String> getAllowedUsers() {
        return allowedUsers;
    }
    public void setAllowedUsers(List<String> allowedUsers) {
        this.allowedUsers = allowedUsers;
    }

    public PrivilegedUserSecurityAllOf addAllowedUsersItem(String allowedUsersItem) {
        if (this.allowedUsers == null) {
            this.allowedUsers = new ArrayList<>();
        }
        this.allowedUsers.add(allowedUsersItem);
        return this;
    }

    

    @Override
    public boolean equals(java.lang.Object o) {

        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PrivilegedUserSecurityAllOf privilegedUserSecurityAllOf = (PrivilegedUserSecurityAllOf) o;
        return Objects.equals(this.allowedUsers, privilegedUserSecurityAllOf.allowedUsers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(allowedUsers);
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append("class PrivilegedUserSecurityAllOf {\n");
        
        sb.append("    allowedUsers: ").append(toIndentedString(allowedUsers)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
    * Convert the given object to string with each line indented by 4 spaces
    * (except the first line).
    */
    private String toIndentedString(java.lang.Object o) {

        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n");
    }
}

