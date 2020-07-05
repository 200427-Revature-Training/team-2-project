import React from 'react';
import { HistoryComponent } from '../../../components/pages/employee/history/history.component';
import { mount, shallow } from 'enzyme';

jest.mock('../../../remote/employee.remote');

const mockfn = jest.fn();

const setUp = (props={}) => {
    const component = shallow(<HistoryComponent {...props} />);
    return component;
}

describe('HistoryComponent', () => {
    beforeEach(() => {
        jest.clearAllMocks();
    });

    test('should render', () => {
        const wrapper = setUp();
        // console.log(wrapper.debug());
        expect(wrapper).toBeDefined();
    });
});