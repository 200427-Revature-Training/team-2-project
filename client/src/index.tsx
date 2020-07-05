import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import App from './App';
import * as serviceWorker from './serviceWorker';
import 'bootstrap/dist/css/bootstrap.min.css';
// import './fontawesome';
import { library } from '@fortawesome/fontawesome-svg-core';
import { faHome, faChartLine, faCalendar, faBusinessTime, faCog } from '@fortawesome/free-solid-svg-icons';

library.add(
  faHome,
  faChartLine,
  faCalendar,
  faBusinessTime,
  faCog
);

ReactDOM.render(
  <React.StrictMode>
    <App />
  </React.StrictMode>,
  document.getElementById('root')
);

// If you want your app to work offline and load faster, you can change
// unregister() to register() below. Note this comes with some pitfalls.
// Learn more about service workers: https://bit.ly/CRA-PWA
serviceWorker.unregister();
