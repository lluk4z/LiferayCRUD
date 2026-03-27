package task.web.portlet.actions;

import br.com.exemplo.meuprojeto.model.Task;
import br.com.exemplo.meuprojeto.service.TaskLocalService;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import task.web.constants.TaskWebPortletKeys;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

@Component(
        property = {
                "javax.portlet.name=" + TaskWebPortletKeys.TASKWEB,
                "mvc.command.name=/task/edit"
        },
        service = MVCRenderCommand.class
)
public class EditTaskRenderCommand implements MVCRenderCommand {
    @Reference
    private TaskLocalService _taskLocalService;

    @Override
    public String render(RenderRequest request, RenderResponse response) {

        long taskId = ParamUtil.getLong(request, "taskId");

        Task task = _taskLocalService.fetchTask(taskId);

        request.setAttribute("task", task);

        return "/edit.jsp";
    }
}
