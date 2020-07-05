import React from 'react';
import { AllTicketsComponent } from '../../../components/pages/admin/all/all-tickets.component';
import { mount, shallow } from 'enzyme';
// import * as adminRemote from '../../../remote/admin.remote';

jest.mock('../../../remote/admin.remote');

const mockfn = jest.fn();

const setUp = (props={}) => {
    const component = shallow(<AllTicketsComponent {...props} />);
    return component;
}

describe('AllTicketsComponent', () => {
    beforeEach(() => {
        jest.clearAllMocks();
    });

    test('should render', () => {
        const wrapper = setUp();
        // console.log(wrapper.debug());
        expect(wrapper).toBeDefined();
    });
});