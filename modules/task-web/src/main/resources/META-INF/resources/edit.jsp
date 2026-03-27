<%@ include file="/init.jsp" %>

<portlet:actionURL name="/task/update" var="updateTaskURL" />

<h1>Edit task ${task.taskId}</h1>

<form action="<%= updateTaskURL %>" method="post">

   <input type="hidden"
          name="<portlet:namespace />taskId"
          value="${task.taskId}" />

    <h3>Title</h3>

    <input type="text"
           name="<portlet:namespace />title"
           value="${task.title}" />

    <h3>Description</h3>

    <input type="text"
           name="<portlet:namespace />description"
           value="${task.description}" />

    <button type="submit">Atualizar</button>
</form>