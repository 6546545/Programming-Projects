// redux/reducers.js
const initialState = { profile: {} };

export const rootReducer = (state = initialState, action) => {
  switch (action.type) {
    case 'SET_PROFILE':
      return { ...state, profile: action.payload };
    default:
      return state;
  }
};
