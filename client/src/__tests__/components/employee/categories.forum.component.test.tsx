import React from 'react';
import { CategoriesForumComponent } from '../../../components/pages/employee/categories-forum/categories.forum.component';
import { mount, shallow } from 'enzyme';

jest.mock('../../../remote/employee.remote');

const mockfn = jest.fn();

const setUp = (props={}) => {
    const component = shallow(<CategoriesForumComponent {...props} />);
    return component;
}

describe('CategoriesForumComponent', () => {
    beforeEach(() => {
        jest.clearAllMocks();
    });

    test('should render', () => {
        const wrapper = setUp();
        // console.log(wrapper.debug());
        expect(wrapper).toBeDefined();
    });



}); 