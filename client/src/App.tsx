import React, { lazy, Suspense } from 'react';
import './App.css';
import { BrowserRouter, Switch, Route, Redirect } from 'react-router-dom';
import EmployeeNavbarComponent from './components/pages/employee/navbar/employee-navbar.component';
import AdminNavbarComponent from './components/pages/admin/navbar/admin-navbar.component';
import { AdminComponent } from './components/pages/admin/admin.component';
import { EmployeeComponent } from './components/pages/employee/employee.component';
import { LoginComponent } from './components/pages/login/login.component';

/**Lazy loading 
const LoginComponent = lazy(() => import('./components/pages/login/login.component').then(({LoginComponent}) => ({default: LoginComponent})));
const TestComponent = lazy(() => import('./components/pages/test/test.component').then(({TestComponent}) => ({default: TestComponent})));
*/

function App() {
  const isEmployee = localStorage.getItem('userName') === 'EmployeeUser'; /**Validate token */ 
  return (
    <BrowserRouter>
    <div className="App">
        <p className="user-role">User Role: { isEmployee ? 'Employee' : 'OTHER' }</p> {/* Test for auth token Validation */} 
        <main>
        {/* <Suspense fallback={<div>Loading...</div>}> Loadbar for lazy loading  */}

          <Route exact path="/">
            <LoginComponent />
          </Route>

          <Switch>
              
              
              <div> 

            {/* <Route path="/template">
            { isEmployee ? (<TestComponent />) : (<Redirect to="/"/>)} Lazy load 
            </Route> */}

            <Route path="/administrator">
              <AdminNavbarComponent />
              <AdminComponent />
            </Route>

            <Route path="/employee"> {/* Change routes url */}
              <EmployeeNavbarComponent />
              <EmployeeComponent />
            </Route>

            </div>
          </Switch>
          {/* </Suspense> */}
        </main>
    </div>
    </BrowserRouter>
  );
}

export default App;
