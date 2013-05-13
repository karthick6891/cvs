<!-- Author: Ben Souther; ben@javaranch.com -->
<html>
  <head>
    <title>Simple Command</title>
  </head>
  <body>
    <h2>Simple Command</h2>  
    <form method="post" action="controller.do">
      <input type="hidden" name="form_action" value="write" />
      <table>
        <tr>
          <td>
            First Name:
          </td>
          <td>
            <input type="text" name="first_name" value="${modelBean.firstName}" />
          </td>
        </tr>
        <tr>
          <td>
            Last Name:
          </td>
          <td>
            <input type="text" name="last_name" value="${modelBean.lastName}" />
          </td>
        </tr>
        <tr>
          <td>
            Email:
          </td>
          <td>
            <input type="text" name="email" value="${modelBean.email}" />
          </td>
        </tr>
        <tr>
          <td>
            Phone:
          </td>
          <td>
            <input type="text" name="phone" value="${modelBean.phone}" />
          </td>
        </tr>
        <tr>
          <td>
            <input type="submit" name="enter_button" value="Enter" />
          </td>
          <td>
          </td>
        </tr>
      </table>
    </form>
    <pre>
      ${modelBean.message}
    <pre>
    <br />    
    <br />    
    <br />    
    <br />    
    <br />    
    <br />    
    <p>
    </p>
  </body>
</html>
