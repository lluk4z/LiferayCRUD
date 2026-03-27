package task.web.portlet.actions;

import br.com.exemplo.meuprojeto.model.Task;
import br.com.exemplo.meuprojeto.service.TaskLocalService;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import task.web.constants.TaskWebPortletKeys;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import java.util.List;

@Component(
        property = {
                "javax.portlet.name=" + TaskWebPortletKeys.TASKWEB,
                "mvc.command.name=/"
        },
        service = MVCRenderCommand.class
)
public class ViewTasksRenderCommand implements MVCRenderCommand {

    @Reference
    private TaskLocalService _taskLocalService;

    @Override
    public String render(RenderRequest request, RenderResponse response) {

        List<Task> tasks = _taskLocalService.getTasks(-1, -1);

        request.setAttribute("tasks", tasks);

        return "/view.jsp";
    }
}