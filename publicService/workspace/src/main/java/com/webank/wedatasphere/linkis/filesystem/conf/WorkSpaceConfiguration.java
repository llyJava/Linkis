/*
 * Copyright 2019 WeBank
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
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

package com.webank.wedatasphere.linkis.filesystem.conf;

import com.webank.wedatasphere.linkis.common.conf.CommonVars;
import com.webank.wedatasphere.linkis.common.conf.CommonVars$;

/**
 * Created by johnnwang on 2018/11/9.
 */
public class WorkSpaceConfiguration {
    public static final CommonVars LOCAL_USER_ROOT_PATH = CommonVars$.MODULE$.apply("wds.linkis.workspace.filesystem.localuserrootpath","file:///tmp/linkis/");
    public static final CommonVars HDFS_USER_ROOT_PATH_PREFIX = CommonVars$.MODULE$.apply("wds.linkis.workspace.filesystem.hdfsuserrootpath.prefix","hdfs:///tmp/");
    public static final CommonVars HDFS_USER_ROOT_PATH_SUFFIX = CommonVars$.MODULE$.apply("wds.linkis.workspace.filesystem.hdfsuserrootpath.suffix","/linkis/");
}
