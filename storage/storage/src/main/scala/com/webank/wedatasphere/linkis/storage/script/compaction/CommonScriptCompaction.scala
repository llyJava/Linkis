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

package com.webank.wedatasphere.linkis.storage.script.compaction

import com.webank.wedatasphere.linkis.storage.script.{Compaction, Variable}

/**
  * Created by johnnwang on 2018/10/23.
  */
abstract class CommonScriptCompaction extends Compaction {

  override def prefisConf: String = "conf@set"

  override def compact(variable: Variable): String = {
    variable.sortParent match {
      case "variable" => prefix + " " + variable.key + "=" + variable.value
      case "configuration" =>prefisConf + " " + variable.sort + " " + variable.key + "=" + variable.value
      //todo Throw an exception(抛出异常)
    }
  }
}

