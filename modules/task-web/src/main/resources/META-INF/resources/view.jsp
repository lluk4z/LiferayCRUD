<%@ include file="/init.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<h1>Lista de Tasks</h1>

<portlet:actionURL name="/task/add" var="addTaskURL" />

<form action="<%= addTaskURL %>" method="post">
    <input type="text" name="<portlet:namespace />title" placeholder="Title" />
    <textarea type="text" name="<portlet:namespace />description" rows="4" cols="50" /> </textarea>
    <button type="submit">Criar</button>
</form>

<hr/>

<c:forEach var="task" items="${tasks}">
    <div>
        <h3>${task.title}</h3>
        <p>${task.description}</p>
    </div>

    <portlet:actionURL name="/task/delete" var="deleteTaskURL">
        <portlet:param name="taskId" value="${task.taskId}" />
    </portlet:actionURL>

    <form action="<%= deleteTaskURL %>" method="post">
        <button type="submit">Deletar</button>
    </form>

    <portlet:renderURL var="editTaskURL">
        <portlet:param name="mvcRenderCommandName" value="/task/edit" />
        <portlet:param name="taskId" value="${task.taskId}" />
    </portlet:renderURL>

    <a href="<%= editTaskURL %>">Editar</a>
</c:forEach>
