package task.rest.internal.graphql.mutation.v1_0;

import com.liferay.petra.function.UnsafeConsumer;
import com.liferay.petra.function.UnsafeFunction;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.service.RoleLocalService;
import com.liferay.portal.vulcan.accept.language.AcceptLanguage;
import com.liferay.portal.vulcan.batch.engine.resource.VulcanBatchEngineImportTaskResource;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLField;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLName;

import java.util.function.BiFunction;

import javax.annotation.Generated;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.osgi.service.component.ComponentServiceObjects;

import task.rest.dto.v1_0.Task;
import task.rest.resource.v1_0.TaskResource;

/**
 * @author me
 * @generated
 */
@Generated("")
public class Mutation {

	public static void setTaskResourceComponentServiceObjects(
		ComponentServiceObjects<TaskResource>
			taskResourceComponentServiceObjects) {

		_taskResourceComponentServiceObjects =
			taskResourceComponentServiceObjects;
	}

	@GraphQLField
	public Response deleteTask(@GraphQLName("taskId") Integer taskId)
		throws Exception {

		return _applyComponentServiceObjects(
			_taskResourceComponentServiceObjects,
			this::_populateResourceContext,
			taskResource -> taskResource.deleteTask(taskId));
	}

	@GraphQLField
	public Response deleteTaskBatch(
			@GraphQLName("callbackURL") String callbackURL,
			@GraphQLName("object") Object object)
		throws Exception {

		return _applyComponentServiceObjects(
			_taskResourceComponentServiceObjects,
			this::_populateResourceContext,
			taskResource -> taskResource.deleteTaskBatch(callbackURL, object));
	}

	@GraphQLField
	public Task createTask(@GraphQLName("task") Task task) throws Exception {
		return _applyComponentServiceObjects(
			_taskResourceComponentServiceObjects,
			this::_populateResourceContext,
			taskResource -> taskResource.postTask(task));
	}

	@GraphQLField
	public Response createTaskBatch(
			@GraphQLName("callbackURL") String callbackURL,
			@GraphQLName("object") Object object)
		throws Exception {

		return _applyComponentServiceObjects(
			_taskResourceComponentServiceObjects,
			this::_populateResourceContext,
			taskResource -> taskResource.postTaskBatch(callbackURL, object));
	}

	private <T, R, E1 extends Throwable, E2 extends Throwable> R
			_applyComponentServiceObjects(
				ComponentServiceObjects<T> componentServiceObjects,
				UnsafeConsumer<T, E1> unsafeConsumer,
				UnsafeFunction<T, R, E2> unsafeFunction)
		throws E1, E2 {

		T resource = componentServiceObjects.getService();

		try {
			unsafeConsumer.accept(resource);

			return unsafeFunction.apply(resource);
		}
		finally {
			componentServiceObjects.ungetService(resource);
		}
	}

	private <T, E1 extends Throwable, E2 extends Throwable> void
			_applyVoidComponentServiceObjects(
				ComponentServiceObjects<T> componentServiceObjects,
				UnsafeConsumer<T, E1> unsafeConsumer,
				UnsafeConsumer<T, E2> unsafeFunction)
		throws E1, E2 {

		T resource = componentServiceObjects.getService();

		try {
			unsafeConsumer.accept(resource);

			unsafeFunction.accept(resource);
		}
		finally {
			componentServiceObjects.ungetService(resource);
		}
	}

	private void _populateResourceContext(TaskResource taskResource)
		throws Exception {

		taskResource.setContextAcceptLanguage(_acceptLanguage);
		taskResource.setContextCompany(_company);
		taskResource.setContextHttpServletRequest(_httpServletRequest);
		taskResource.setContextHttpServletResponse(_httpServletResponse);
		taskResource.setContextUriInfo(_uriInfo);
		taskResource.setContextUser(_user);
		taskResource.setGroupLocalService(_groupLocalService);
		taskResource.setRoleLocalService(_roleLocalService);

		taskResource.setVulcanBatchEngineImportTaskResource(
			_vulcanBatchEngineImportTaskResource);
	}

	private static ComponentServiceObjects<TaskResource>
		_taskResourceComponentServiceObjects;

	private AcceptLanguage _acceptLanguage;
	private com.liferay.portal.kernel.model.Company _company;
	private GroupLocalService _groupLocalService;
	private HttpServletRequest _httpServletRequest;
	private HttpServletResponse _httpServletResponse;
	private RoleLocalService _roleLocalService;
	private BiFunction<Object, String, com.liferay.portal.kernel.search.Sort[]>
		_sortsBiFunction;
	private UriInfo _uriInfo;
	private com.liferay.portal.kernel.model.User _user;
	private VulcanBatchEngineImportTaskResource
		_vulcanBatchEngineImportTaskResource;

}