package task.web.portlet.actions;

import br.com.exemplo.meuprojeto.service.TaskLocalService;
import com.liferay.portal.kernel.exception.PortalException;
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
                "mvc.command.name=/task/delete"
        },
        service = MVCActionCommand.class
)
public class DeleteTaskMVCActionCommand implements MVCActionCommand {
    @Reference
    private TaskLocalService _taskLocalService;

    @Override
    public boolean processAction(ActionRequest request, ActionResponse response) {

        long taskId = ParamUtil.getLong(request, "taskId");

        try {
            _taskLocalService.deleteTask(taskId);
        } catch (PortalException e) {
            throw new RuntimeException(e);
        }

        return true;
    }
}
