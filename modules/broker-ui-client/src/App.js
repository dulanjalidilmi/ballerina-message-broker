/*
* Copyright (c) 2019, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
*
* WSO2 Inc. licenses this file to you under the Apache License,
* Version 2.0 (the "License"); you may not use this file except
* in compliance with the License.
* You may obtain a copy of the License at
*
* http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing,
* software distributed under the License is distributed on an
* "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
* KIND, either express or implied. See the License for the
* specific language governing permissions and limitations
* under the License.
*/

import React from 'react';
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';

import Exchange from './components/Base/Container/Exchange';

import Queue from './components/Base/Container/Queue';
import Consumer from './components/Base/Container/Consumer';
import ExchangeClicked from './components/Base/Container/Tables/ExchangeClicked';
import QueuesClicked from './components/Base/Container/Tables/QueuesClicked';

import Main from './components/main';
import PrivateRoute from './PrivateRoute';

class App extends React.Component {
	/**
 	 * Define base routes for the application
 	 * 
 	 */

	render() {
		return (
			<div>
				<Router>
					<Switch>
						<Route exact path="/" render={(props) => <Main />} />
						<PrivateRoute exact path="/exchange" component={Exchange} />
						<PrivateRoute exact path="/queue" component={Queue} />
						<PrivateRoute exact path="/consumer" component={Consumer} />
						<PrivateRoute exact path="/consumer/:name" component={Consumer} />
						<PrivateRoute exact path="/exchange/:name" component={ExchangeClicked} />
						<PrivateRoute exact path="/queue/:name" component={QueuesClicked} />
					</Switch>
				</Router>
			</div>
		);
	}
}
export default App;
