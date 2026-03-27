/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package br.com.exemplo.meuprojeto.service.impl;

import br.com.exemplo.meuprojeto.model.Task;
import br.com.exemplo.meuprojeto.service.base.TaskLocalServiceBaseImpl;

import com.liferay.portal.aop.AopService;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;
import org.osgi.service.component.annotations.Component;

import java.util.Date;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=br.com.exemplo.meuprojeto.model.Task",
	service = AopService.class
)
public class TaskLocalServiceImpl extends TaskLocalServiceBaseImpl {
	public Task addTask(
			long userId,
			String title,
			String description) throws PortalException {

		long taskId = counterLocalService.increment();

		Task task = taskPersistence.create(taskId);

		User user = userLocalService.getUser(userId);

		task.setUserId(userId);
		task.setUserName(user.getFullName());
		task.setCompanyId(user.getCompanyId());
		task.setGroupId(user.getGroupId());
		task.setCreateDate(new Date());
		task.setModifiedDate(new Date());

		task.setTitle(title);
		task.setDescription(description);
		task.setCompleted(false);

		return taskPersistence.update(task);
	}

	public Task updateTask(
			long taskId,
			String title,
			String description,
			boolean completed,
			ServiceContext serviceContext) throws PortalException {

		Task task = taskPersistence.findByPrimaryKey(taskId);

		task.setTitle(title);
		task.setDescription(description);
		task.setCompleted(completed);

		task.setModifiedDate(serviceContext.getModifiedDate(new Date()));

		return super.updateTask(task);
	}
}