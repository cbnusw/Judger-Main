// 루트 리듀서
import { combineReducers } from 'redux';
import auth from './auth';
import loading from './loading';

const rootReducer = combineReducers({
    auth,
    loading,
});

export default rootReducer;