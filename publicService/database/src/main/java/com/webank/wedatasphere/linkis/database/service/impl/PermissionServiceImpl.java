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

package com.webank.wedatasphere.linkis.database.service.impl;

import com.diffplug.common.base.Errors;
import com.webank.wedatasphere.linkis.database.dao.PermissionDao;
import com.webank.wedatasphere.linkis.database.domain.View;
import com.webank.wedatasphere.linkis.database.service.FilterService;
import com.webank.wedatasphere.linkis.database.service.PermissionService;
import com.webank.wedatasphere.linkis.database.service.ViewService;
import com.webank.wedatasphere.linkis.database.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * Created by shanhuang on 9/13/18.
 */
@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired(required = false)
    PermissionDao permissionDao;

    @Autowired
    FilterService filterService;

    @Autowired
    ViewService viewService;

    @Override
    public void createPermission(View view, String userName) throws Exception {
        View existing = viewService.getById(view.getId());
        view.getPermissions().forEach(Errors.rethrow().wrap(permission -> {
            permission.setInfoOnCreate(userName);
            permissionDao.insert(permission);
            if(Constants.ROW.equals(permission.getType())){
                permission.getFilter().setPermissionId(permission.getId());
                filterService.create(permission.getFilter(), existing, userName);
            }
        }));
    }

    @Override
    public void updatePermission(View view, String userName) throws Exception {
        view.getPermissions().forEach(permission -> {
            permission.setInfoOnUpdate(userName);
            permissionDao.update(permission);
        });

    }

    @Override
    public void delete(Integer id) throws Exception {
        permissionDao.deleteById(id);
    }
}
