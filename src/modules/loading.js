import { createAction, handleActions } from 'redux-actions';

const START_LOADING = 'loading/START_LOADING';
const FINISH_LOADING = 'loading/FINISH_LOADING';

/**
 * 요청을 위한 액션 타입을 payload로 설정
 */
export const startLoading = createAction(
    STRAT_LOADING,
    requestType => requestType,
);

export const finishLoading = createAction(
    FINISH_LOADING,
    requestType => requestType,
);

const initailState = {};

const loading = handleActions(
    {
        [START_LOADING]: (state, action) => ({
            ...state,
            [action.payload]:true,
        }),
        [FINISH_LOADING]: (state, action) => ({
            ...state,
            [action.payload]: false,
        }),
    },
    initialState,
);

export default loading;