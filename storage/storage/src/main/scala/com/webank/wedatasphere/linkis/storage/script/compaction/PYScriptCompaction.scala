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

/**
  * Created by johnnwang on 2018/10/23.
  */
class PYScriptCompaction private extends CommonScriptCompaction {

  override def belongTo(suffix: String): Boolean = {
    suffix match {
      case "python"|"py" => true
      case _ => false
    }
  }

  override def prefix: String = "#@set"
}

object PYScriptCompaction {
  val pYScriptCompaction: PYScriptCompaction = new PYScriptCompaction

  def apply(): CommonScriptCompaction = pYScriptCompaction
}
