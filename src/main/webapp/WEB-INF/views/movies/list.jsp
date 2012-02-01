<%@ page session="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h2>Results for &quot;${query}&quot;</h2>

    <ul class="search-results">
      <c:forEach items="${movies}" var="movie">
        <li>
          <div class="search-result-details">
          ${movie.title}<br/>
          </div>
        </li>
      </c:forEach>
    </ul>
