package task.web.portlet.actions;

import br.com.exemplo.meuprojeto.model.Task;
import br.com.exemplo.meuprojeto.service.TaskLocalService;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import task.web.constants.TaskWebPortletKeys;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

@Component(
        property = {
                "javax.portlet.name=" + TaskWebPortletKeys.TASKWEB,
                "mvc.command.name=/task/update"
        },
        service = MVCActionCommand.class
)
public class UpdateTaskMVCActionCommand implements MVCActionCommand {

    @Reference
    private TaskLocalService _taskLocalService;

    @Override
    public boolean processAction(ActionRequest request, ActionResponse response) {

        long taskId = ParamUtil.getLong(request, "taskId");
        String title = ParamUtil.getString(request, "title");
        String description = ParamUtil.getString(request, "description");
        boolean completed = ParamUtil.getBoolean(request, "completed");

        try {
            Task task = _taskLocalService.getTask(taskId);

            task.setTitle(title);
            task.setDescription(description);
            task.setCompleted(completed);

            _taskLocalService.updateTask(task);


        } catch (Exception e) {
            e.printStackTrace();
        }

        response.setRenderParameter("mvcRenderCommandName", "/");

        return true;
    }
}
