package task.rest.internal.graphql.servlet.v1_0;

import com.liferay.portal.kernel.util.ObjectValuePair;
import com.liferay.portal.vulcan.graphql.servlet.ServletData;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Generated;

import org.osgi.framework.BundleContext;
import org.osgi.service.component.ComponentServiceObjects;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceScope;

import task.rest.internal.graphql.mutation.v1_0.Mutation;
import task.rest.internal.graphql.query.v1_0.Query;
import task.rest.internal.resource.v1_0.TaskResourceImpl;
import task.rest.resource.v1_0.TaskResource;

/**
 * @author me
 * @generated
 */
@Component(service = ServletData.class)
@Generated("")
public class ServletDataImpl implements ServletData {

	@Activate
	public void activate(BundleContext bundleContext) {
		Mutation.setTaskResourceComponentServiceObjects(
			_taskResourceComponentServiceObjects);

		Query.setTaskResourceComponentServiceObjects(
			_taskResourceComponentServiceObjects);
	}

	public String getApplicationName() {
		return "TaskRest";
	}

	@Override
	public Mutation getMutation() {
		return new Mutation();
	}

	@Override
	public String getPath() {
		return "/task-rest-graphql/v1_0";
	}

	@Override
	public Query getQuery() {
		return new Query();
	}

	public ObjectValuePair<Class<?>, String> getResourceMethodObjectValuePair(
		String methodName, boolean mutation) {

		if (mutation) {
			return _resourceMethodObjectValuePairs.get(
				"mutation#" + methodName);
		}

		return _resourceMethodObjectValuePairs.get("query#" + methodName);
	}

	private static final Map<String, ObjectValuePair<Class<?>, String>>
		_resourceMethodObjectValuePairs =
			new HashMap<String, ObjectValuePair<Class<?>, String>>() {
				{
					put(
						"mutation#deleteTask",
						new ObjectValuePair<>(
							TaskResourceImpl.class, "deleteTask"));
					put(
						"mutation#deleteTaskBatch",
						new ObjectValuePair<>(
							TaskResourceImpl.class, "deleteTaskBatch"));
					put(
						"mutation#createTask",
						new ObjectValuePair<>(
							TaskResourceImpl.class, "postTask"));
					put(
						"mutation#createTaskBatch",
						new ObjectValuePair<>(
							TaskResourceImpl.class, "postTaskBatch"));

					put(
						"query#task",
						new ObjectValuePair<>(
							TaskResourceImpl.class, "getTask"));
					put(
						"query#tasks",
						new ObjectValuePair<>(
							TaskResourceImpl.class, "getTasks"));
				}
			};

	@Reference(scope = ReferenceScope.PROTOTYPE_REQUIRED)
	private ComponentServiceObjects<TaskResource>
		_taskResourceComponentServiceObjects;

}