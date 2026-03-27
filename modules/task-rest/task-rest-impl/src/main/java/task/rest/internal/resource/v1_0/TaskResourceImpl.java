package task.rest.internal.resource.v1_0;

import com.liferay.portal.kernel.security.access.control.AccessControlled;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ServiceScope;

import task.rest.dto.v1_0.Task;
import task.rest.resource.v1_0.TaskResource;


import br.com.exemplo.meuprojeto.service.TaskLocalService;

import com.liferay.portal.vulcan.pagination.Page;
import com.liferay.portal.vulcan.pagination.Pagination;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.List;
import java.util.stream.Collectors;
/**
 * @author me
 */
@Component(
	properties = "OSGI-INF/liferay/rest/v1_0/task.properties",
	scope = ServiceScope.PROTOTYPE, service = TaskResource.class
)
public class TaskResourceImpl extends BaseTaskResourceImpl {
	@Reference
	private TaskLocalService taskLocalService;

	@Override
	@AccessControlled(guestAccessEnabled = true)
	public Page<Task> getTasks() throws Exception {

		List<br.com.exemplo.meuprojeto.model.Task> entities =
				taskLocalService.getTasks(-1, -1); // -1, -1 = todos

		List<Task> dtos = entities.stream()
				.map(this::_toDTO)
				.collect(Collectors.toList());

		return Page.of(dtos);
	}

	private Task _toDTO(br.com.exemplo.meuprojeto.model.Task entity) {

		Task dto = new Task();

		dto.setTaskId((int) entity.getTaskId());
		dto.setTitle(entity.getTitle());
		dto.setDescription(entity.getDescription());
		dto.setCompleted(entity.getCompleted());

		return dto;
	}
}