package task.web.portlet.actions;

import br.com.exemplo.meuprojeto.model.Task;
import br.com.exemplo.meuprojeto.service.TaskLocalService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import task.web.constants.TaskWebPortletKeys;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

@Component(
        property = {
                "javax.portlet.name=" + TaskWebPortletKeys.TASKWEB,
                "mvc.command.name=/task/add"
        },
        service = MVCActionCommand.class
)
public class AddTaskMVCActionCommand implements MVCActionCommand {
    @Reference
    private TaskLocalService _taskLocalService;

    @Override
    public boolean processAction(ActionRequest request, ActionResponse response) {

        String title = ParamUtil.getString(request, "title");
        String description = ParamUtil.getString(request, "description");

        ThemeDisplay themeDisplay =
                (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);

        long userId = themeDisplay.getUserId();

        ServiceContext serviceContext = null;
        try {
            serviceContext = ServiceContextFactory.getInstance(
                    Task.class.getName(), request);
        } catch (PortalException e) {
            throw new RuntimeException(e);
        }

        try {
            _taskLocalService.addTask(userId, title, description);
        } catch (PortalException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

        return true;
    }
}
