import React from 'react';
import { NavPanelComponent } from '../../../components/pages/admin/nav-panel/nav-panel.component';
import { mount, shallow } from 'enzyme';

const setUp = (props={}) => {
    const component = shallow(<NavPanelComponent {...props} />);
    return component;
}

describe('NavPanelComponent', () => {
    beforeEach(() => {
        jest.clearAllMocks();
    });

    test('should render', () => {
        const wrapper = setUp();
        // console.log(wrapper.debug());
        expect(wrapper).toBeDefined();
    });
});