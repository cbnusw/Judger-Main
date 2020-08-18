// 루트 리듀서
import { combineReducers } from 'redux';
import auth from './auth';

const rootReducer = combineReducers({
    auth,
});

export default rootReducer;