import React, { lazy, Suspense } from 'react';
import './App.css';
import { BrowserRouter, Switch, Route, Redirect } from 'react-router-dom';
import NavbarComponent from './components/main/navbar.component';

const LoginComponent = lazy(() => import('./components/login/login.component').then(({LoginComponent}) => ({default: LoginComponent})));
const TestComponent = lazy(() => import('./components/test/test.component').then(({TestComponent}) => ({default: TestComponent})));


function App() {
  const isEmployee = localStorage.getItem('userName') === 'EmployeeUser';
  return (
    <BrowserRouter>
    <div className="App">
        <p>User Role: { isEmployee ? 'Employee' : 'OTHER' }</p>
        <main>
        <Suspense fallback={<div>Loading...</div>}>

          <Switch>
              <Route exact path="/">
                <LoginComponent />
              </Route>
              
              <div> 
              <NavbarComponent />

            <Route path="/template">
            { isEmployee ? (<TestComponent />) : (<Redirect to="/"/>)}
            </Route>
            </div>
          </Switch>
          </Suspense>
        </main>
    </div>
    </BrowserRouter>
  );
}

export default App;
